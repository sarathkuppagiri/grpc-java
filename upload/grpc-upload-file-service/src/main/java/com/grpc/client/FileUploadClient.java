package com.grpc.client;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;

import com.google.protobuf.ByteString;
import com.grpc.fileupload.File;
import com.grpc.fileupload.FileServiceGrpc;
import com.grpc.fileupload.FileUploadRequest;
import com.grpc.fileupload.FileUploadResponse;
import com.grpc.fileupload.MetaData;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class FileUploadClient {

	private static FileServiceGrpc.FileServiceStub fileServiceStub;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		


		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		fileServiceStub = FileServiceGrpc.newStub(channel);

		CountDownLatch latch = new CountDownLatch(1);
		StreamObserver<FileUploadRequest> streamObserver = fileServiceStub.upload(new FileUploadObserver(latch));
		Instant start = Instant.now();
		// input file for testing
		Path path = Paths.get("/Users/sarathkumarreddy/Downloads/output-1.jpg");

		// build metadata
		FileUploadRequest metadata = FileUploadRequest.newBuilder()
				.setMetadata(MetaData.newBuilder().setName("output").setType("jpg").build()).build();
		streamObserver.onNext(metadata);

		// upload bytes
		InputStream inputStream = Files.newInputStream(path);
		byte[] bytes = new byte[3000000];
		int size;
		while ((size = inputStream.read(bytes)) > 0) {
			FileUploadRequest uploadRequest = FileUploadRequest.newBuilder()
					.setFile(File.newBuilder().setContent(ByteString.copyFrom(bytes, 0, size)).build()).build();
			streamObserver.onNext(uploadRequest);
		}
		// close the stream
		inputStream.close();
		streamObserver.onCompleted();
		latch.await();
		System.out.println("awit....");
		 Instant finish = Instant.now();
		 System.out.println("finish...."+finish);
		 long timeElapsed = Duration.between(start, finish).toMillis();  //in millis
		System.out.println("Execution time: " + timeElapsed);

	}

	private static class FileUploadObserver implements StreamObserver<FileUploadResponse> {

		private final CountDownLatch latch;

		public FileUploadObserver(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void onNext(FileUploadResponse fileUploadResponse) {
			System.out.println("File upload status :: " + fileUploadResponse.getStatus());
		}

		@Override
		public void onError(Throwable throwable) {
			throwable.printStackTrace();
			this.latch.countDown();
		}

		@Override
		public void onCompleted() {
			System.out.println("Done");
			Instant finish = Instant.now();
			this.latch.countDown();
		}
	}

}
