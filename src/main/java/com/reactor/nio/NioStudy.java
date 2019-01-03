package com.reactor.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;

/**
 * @author chenshun00@gmail.com
 * @since 2018/12/22
 */
public class NioStudy {
    private static SelectorProvider selectorProvider = SelectorProvider.provider();

    public static void main(String[] args) throws Exception {
        //打开一份服务端channel
        ServerSocketChannel server = selectorProvider.openServerSocketChannel();
        //设置channel为非阻塞
        server.configureBlocking(false);
        //绑定这个channel上的socket
        ServerSocket socket = server.socket();
        socket.bind(new InetSocketAddress(8088));
        //获取selector
        Selector selector = selectorProvider.openSelector();
        //注册channel到 连接事件上，等待前来连接到tcp#channel
        server.register(selector, SelectionKey.OP_ACCEPT);
        Thread.sleep(10000000000L);

    }
}
