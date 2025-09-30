package scripts;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MemberPage;


public class MemberTest extends BaseTest {
    @Test
    public void registerMemberComplete() {
        LoginPage loginPage = new LoginPage(driver);
        MemberPage memberPage = new MemberPage(driver);


        loginPage.login("admin","123456");
        memberPage.accessCreateMemberPage();

        memberPage.chosingTier("Friends Dumon");

        memberPage.chosingApprove("승인");
        memberPage.inputID("hehe", "luanku");
        memberPage.inputEmail("keke", "ss");

    }
}