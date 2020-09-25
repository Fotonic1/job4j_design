package ru.job4j.template;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GeneratorTest {

    @Test
    public void whenGenerate() {
        Generator gen = new Gen();
        String rsl = gen.produce("I am a ${name}, Who are ${subject}? ",
                Map.of("name", "Vlad", "subject", "you"));
        assertThat(rsl, is("I am a Vlad, Who are you? "));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMapEr() {
        Generator gen = new Gen();
        gen.produce("I am a ${name}, Who are ${subject}? ",
                Map.of("name", "Vlad"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMapHuge() {
        Generator gen = new Gen();
        gen.produce("I am a ${name}, Who are ${subject}? ",
                Map.of("name", "Vlad", "subject", "you", "1", "1"));
    }
}