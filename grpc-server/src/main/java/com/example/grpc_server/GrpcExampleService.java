package com.example.grpc_server;

import example.proto.Example.HelloRequest;
import example.proto.Example.HelloResponse;
import example.proto.ExampleProtoServiceGrpc.ExampleProtoServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
// {proto에 설정된 package}.{proto에 설정된 서비스}Grpc.{proto에 설정된 서비스}ImplBase를 extends
public class GrpcExampleService extends ExampleProtoServiceImplBase {

  // 자동완성 기능으로 Override해줍니다.
  @Override
  public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
    // ... 원하는 코드 작성
    // 아래는 예시 코드
    HelloResponse reply = HelloResponse.newBuilder()
        .setMessage("Hello " + request.getName())
        .build();
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }
}
