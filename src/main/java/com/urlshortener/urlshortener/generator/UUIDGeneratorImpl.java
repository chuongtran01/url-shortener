package com.urlshortener.urlshortener.generator;

import com.urlshortener.urlshortener.encoder.Base10Encoder;
import com.urlshortener.urlshortener.encoder.BaseEncoder;

import java.util.Random;

public class UUIDGeneratorImpl implements UUIDGenerator{

    public final static UUIDGenerator uuidGenerator = new UUIDGeneratorImpl();
    public Long create() {
        Random random = new Random();
        return random.nextLong(10000000000000L);
    }
}
