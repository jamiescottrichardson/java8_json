package com.ibm.cic.br.seeds;

import org.junit.Test;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testGetProspectJson() throws IOException {
        App $app = new App();
        assertNotNull($app.getProspectJson());
    }

    @Test
    public void testConvertToProspectList() throws IOException {
        App $app = new App();
        String json = $app.getProspectJson();
        assertEquals(100, $app.convertToProspectList(json).size());
    }

    @Test
    public void testCase1() throws IOException {
        App $app = new App();
        String json = $app.getProspectJson();
        Optional<Prospect> prospect = $app.example1($app.convertToProspectList(json));
        assertNotNull(prospect);
    }

    @Test
    public void testCase2() throws IOException {
        App $app = new App();
        String json = $app.getProspectJson();
        Optional<Prospect> prospect = $app.example2($app.convertToProspectList(json));
        assertNotNull(prospect);
    }

    @Test
    public void testCase3() throws IOException {
        App $app = new App();
        String json = $app.getProspectJson();
        Map<String, Long> map = $app.example3($app.convertToProspectList(json));
        assertTrue(map.get("LA") > 0);
    }
}
