package com.bootapp.service.core.uaa.auth;

import com.bootapp.service.core.ice.common.RpcService;

import com.bootapp.service.core.proto.Rpc;
import com.google.protobuf.InvalidProtocolBufferException;
import com.zeroc.Ice.Current;

public class AuthService implements RpcService {

    @Override
    public byte[] query(String path, byte[] params, Current current) {
        Rpc.Payload.Builder responseBuilder = Rpc.Payload.newBuilder();
        responseBuilder.putData("result", "ok");
        return responseBuilder.build().toByteArray();
    }

    @Override
    public byte[] invoke(String path, byte[] params, byte[] body, Current current) {
        Rpc.Payload.Builder bodyBuilder = Rpc.Payload.newBuilder();
        try {
            bodyBuilder.mergeFrom(body);
            Rpc.Payload bodyProto = bodyBuilder.build();
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        Rpc.Payload.Builder responseBuilder = Rpc.Payload.newBuilder();
        responseBuilder.putData("result", "ok");
        return responseBuilder.build().toByteArray();
    }
}
