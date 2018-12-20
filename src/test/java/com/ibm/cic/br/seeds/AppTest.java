package com.ibm.cic.br.seeds;

import org.junit.Test;

import java.io.IOException;
import java.util.List;
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
    @Test
    public void testCase4() throws IOException
    {
    	App $app = new App();
        String json = $app.getProspectJson();
        List<Prospect> listla = $app.example4($app.convertToProspectList(json));
        assertTrue(listla.size()>0);
    }
    @Test
    public void testCase5() throws Exception {
    	App $app = new App();
        String json = $app.getProspectJson();
        List<Customer> customers = $app.example5($app.convertToProspectList(json), "MS");
        assertFalse(customers.isEmpty());
    }
    @Test
    public void testCase6() throws IOException {
    	App $app = new App();
        String json = $app.getProspectJson();
        List<String> fullname = $app.example6($app.convertToProspectList(json));
        assertTrue(fullname.size()==100);
    }
    @Test
    public void testCase7() throws IOException {
    	App $app = new App();
        String json = $app.getProspectJson();
        List<Prospect> subnet_13_24= $app.example7($app.convertToProspectList(json));
        assertFalse(subnet_13_24.isEmpty());
    }
    @Test
    public void testCase8() throws IOException {
    	App $app = new App();
        String json = $app.getProspectJson();
        List<Customer> endswithson = $app.example8($app.convertToProspectList(json));
        assertTrue(endswithson.isEmpty());
    }
    @Test
    public void testCase9() throws IOException {
    	App $app = new App();
        String json = $app.getProspectJson();
        Map<String,Long> subnetcount = $app.example9($app.convertToProspectList(json));
        assertTrue(subnetcount.get("13")==10);
    }
    @Test
    public void testCase10() throws IOException {
    	App $app = new App();
        String json = $app.getProspectJson();
        List<Customer> add30 = $app.example10($app.convertToProspectList(json));
        assertFalse(add30.isEmpty());
    }
}
