package com.dolgosheev.sandbox;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HelloTest {

    @Test
    void greetsByName() {

        Hello hello = new Hello();

        String result = hello.greet("Aleksandr");

        assertThat(result).isEqualTo("Hello Aleksandr");
    }
}