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
package com.reactor.app;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;

import com.reactor.framework.AbstractNioChannel;
import com.reactor.framework.ChannelHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * Logging server application logic. It logs the incoming requests on standard console and returns a
 * canned acknowledgement back to the remote peer.
 */
@Slf4j
public class LoggingHandler implements ChannelHandler {

    private static final byte[] ACK = "Data logged successfully".getBytes();

    /**
     * Decodes the received data and logs it on standard console.
     */
    @Override
    public void handleChannelRead(AbstractNioChannel channel, Object readObject, SelectionKey key) {
        /*
         * As this handler is attached with both TCP and UDP channels we need to check whether the data
         * received is a ByteBuffer (from TCP channel) or a DatagramPacket (from UDP channel).
         */
        if (readObject instanceof ByteBuffer) {
            doLogging((ByteBuffer) readObject);
            sendReply(channel, key);
        } else {
            throw new IllegalStateException("Unknown data received");
        }
    }

    private static void sendReply(AbstractNioChannel channel, SelectionKey key) {
        ByteBuffer buffer = ByteBuffer.wrap(ACK);
        channel.write(buffer, key);
    }

    private static void doLogging(ByteBuffer data) {
        // assuming UTF-8 :(
        log.info("接收到信息,打印日志:{}", new String(data.array(), 0, data.limit()));
    }
}
