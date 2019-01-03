/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.reactor.framework;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;

/**
 * 包装了 {@link ServerSocketChannel} ,能够从 {@link SocketChannel}读取或者写入数据
 */
@Slf4j
public class NioServerSocketChannel extends AbstractNioChannel {

    private final int port;
    private static SelectorProvider selectorProvider = SelectorProvider.provider();

    /**
     * 构造器方法，主要使用selectorProvider打开一个channel ,可以看看
     * <a href="https://github.com/netty/netty/issues/2308">#2308</a>.
     */
    public NioServerSocketChannel(int port, ChannelHandler handler) throws IOException {
        super(handler, selectorProvider.openServerSocketChannel());
        this.port = port;
    }


    @Override
    public int getInterestedOps() {
        // being a server socket channel it is interested in accepting connection from remote peers.
        return SelectionKey.OP_ACCEPT;
    }

    /**
     * @return the underlying {@link ServerSocketChannel}.
     */
    @Override
    public ServerSocketChannel getJavaChannel() {
        return (ServerSocketChannel) super.getJavaChannel();
    }

    /**
     * Reads and returns {@link ByteBuffer} from the underlying {@link SocketChannel} represented by
     * the <code>key</code>. Due to the fact that there is a dedicated channel for each client
     * connection we don't need to store the sender.
     */
    @Override
    public ByteBuffer read(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = socketChannel.read(buffer);
        buffer.flip();
        if (read == -1) {
            throw new IOException("Socket closed");
        }
        return buffer;
    }

    /**
     * 监听端口,相较于 <a href="https://github.com/netty/netty">netty</a> 到不断回调，这里到处理比较简单，直接处理了
     */
    @Override
    public void bind() throws IOException {
        getJavaChannel().socket().bind(new InetSocketAddress(InetAddress.getLocalHost(), port));
        getJavaChannel().configureBlocking(false);
        log.info("Bound TCP socket at port:{}", port);
    }

    /**
     * Writes the pending {@link ByteBuffer} to the underlying channel sending data to the intended
     * receiver of the packet.
     */
    @Override
    protected void doWrite(Object pendingWrite, SelectionKey key) throws IOException {
        ByteBuffer pendingBuffer = (ByteBuffer) pendingWrite;
        ((SocketChannel) key.channel()).write(pendingBuffer);
    }
}
