package com.sms.service;

import com.sms.configuration.TwilioConfiguration;
import com.sms.model.SmsModel;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.twilio.type.PhoneNumber;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class SmsService {
    private final TwilioConfiguration twilioConfiguration;

    public void send(SmsModel sms) {
        Message message = Message.creator(
                        new PhoneNumber(sms.getSendTo()),
                        new PhoneNumber(twilioConfiguration.getTrailNumber()),
                        sms.getMessage())
//                        .setMediaUrl(
//                                Promoter.listOfOne(URI.create("https://www.google.com"))
//                        )
                        .create();
        System.out.println("here is my id:"+message.getSid());

    }
}
