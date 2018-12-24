[["java:package:com.bootapp.service.core.ice"]]
module common {
    sequence<byte> ByteSeq;
    interface RpcService{
        ByteSeq query(string path, ByteSeq params);
        ByteSeq invoke(string path, ByteSeq params, ByteSeq body);
    };
};