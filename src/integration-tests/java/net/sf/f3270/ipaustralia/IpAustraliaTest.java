package net.sf.f3270.ipaustralia;

import static org.junit.Assert.assertTrue;

import net.sf.f3270.IntegrationTestBase;
import net.sf.f3270.Terminal;
import net.sf.f3270.IntegrationTestBase.Mode;

import org.junit.Test;

public class IpAustraliaTest extends IntegrationTestBase {

    public String getHostname() {
        return "pericles.ipaustralia.gov.au";
    }

    public Mode getMode() {
        return Mode.REPLAY;
    }

    @Test
    public void testIpaustralia() {
        connect();

        assertText(terminal, "A U S T R A L I A");
        terminal.enter();
        assertText(terminal, "DISCLAIMER");
        terminal.enter();
        assertText(terminal, "Logon in progress...");
        sleep(100);
        terminal.enter();
        terminal.write("command", "1");
        terminal.read("command");
        terminal.enter();
        terminal.enter();
        terminal.write("command", "2");
        terminal.enter();
        terminal.write("trade mark number", "123");

        disconnect();
    }

    private void assertText(Terminal terminal, String text) {
        assertTrue("screen doesn't contain " + text, terminal.getScreenText().contains(text));
    }

}