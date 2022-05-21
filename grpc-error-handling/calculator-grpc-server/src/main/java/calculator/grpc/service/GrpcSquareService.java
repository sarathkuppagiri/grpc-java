package calculator.grpc.service;

import com.vinsguru.calculator.CalculatorServiceGrpc;
import com.vinsguru.calculator.ErrorCode;
import com.vinsguru.calculator.ErrorResponse;
import com.vinsguru.calculator.Request;
import com.vinsguru.calculator.Response;
import com.vinsguru.calculator.SuccessResponse;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class GrpcSquareService extends CalculatorServiceGrpc.CalculatorServiceImplBase {

	@Override
	public void findSquare(Request request, StreamObserver<Response> responseObserver) {
		int number = request.getNumber();

		Response.Builder builder = Response.newBuilder();
		if (number < 2 || number > 20) {
			ErrorCode errorCode = number > 20 ? ErrorCode.ABOVE_20 : ErrorCode.BELOW_2;
			ErrorResponse errorResponse = ErrorResponse.newBuilder().setInput(number).setErrorCode(errorCode).build();
			builder.setErrorResponse(errorResponse);
		} else {
			// only valid ranges
			builder.setSuccessResponse(SuccessResponse.newBuilder().setResult(number * number).build());
		}
		responseObserver.onNext(builder.build());
		responseObserver.onCompleted();
	}

}
