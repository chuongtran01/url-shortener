package com.urlshortener.urlshortener.encoder;

public interface BaseEncoder {

    String encode(long number);

    long decode(String number);

}