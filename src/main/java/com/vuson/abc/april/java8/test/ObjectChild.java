package com.vuson.abc.april.java8.test;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;


@Data
@AllArgsConstructor
public class ObjectChild {

    Instant time;

    double value;

}
