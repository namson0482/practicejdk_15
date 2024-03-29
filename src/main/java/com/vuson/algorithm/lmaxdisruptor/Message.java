package com.vuson.algorithm.lmaxdisruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by Rohit Sachan on 1/13/14.
 */
public class Message {
    private Integer msg;

    public void setMsg(Integer msg) {
        this.msg = msg;
    }

    public Integer getMsg() {
        return msg;
    }

    public final static EventFactory<Message> EVENT_FACTORY = new EventFactory<Message>() {
        @Override
        public Message newInstance() {
            return new Message();
        }
    };

}
