package com.bootapp.service.core.uaa;

import com.bootapp.service.core.uaa.auth.AuthService;

public class Application {
    public static void main(String[] args)
    {
        com.zeroc.Ice.Properties properties = com.zeroc.Ice.Util.createProperties();
        properties.setProperty("Ice.MessageSizeMax", "10240");
        com.zeroc.Ice.InitializationData initData = new com.zeroc.Ice.InitializationData();
        initData.properties = properties;
        try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(initData))
        {
            com.zeroc.Ice.ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("AuthServiceAdapter", "default -p 10000");
            com.zeroc.Ice.Object object = new AuthService();
            adapter.add(object, com.zeroc.Ice.Util.stringToIdentity("AuthService"));
            adapter.activate();
            communicator.waitForShutdown();
        }
    }
}
