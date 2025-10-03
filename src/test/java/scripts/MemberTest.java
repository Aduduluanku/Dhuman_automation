package scripts;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MemberPage;
import java.util.UUID;



public class MemberTest extends BaseTest {
    @Test
    public void registerMemberComplete() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        MemberPage memberPage = new MemberPage(driver);

        String timestamp = String.valueOf(System.currentTimeMillis());
        String uid = timestamp.substring(timestamp.length() - 6);

        String userId = "user" + uid;
        String userName = "userName_" + uid;
        String emailFront = "mailReal" + uid;
        String emailDomain = "@gmail.com";
        String phoneNumber = "0106" + uid;


        loginPage.login("admin","123456");
        memberPage.accessCreateMemberPage();

        memberPage.chosingTier("Friends Dumon");

        memberPage.chosingApprove("승인");
//        memberPage.inputID("user", "luanku");
//        memberPage.inputPwd("Thangchobo123");
//        memberPage.inputEmail("keke", "ss");

        memberPage.inputID(userId, userName);
        memberPage.inputPwd("Thangchobo123");
        memberPage.checkSeePwd();
        memberPage.inputEmail(emailFront, emailDomain);
        memberPage.tickAnnounceMail();

        memberPage.inputPhoneNumber(phoneNumber);
        memberPage.tickAnnounceSms();

        memberPage.findZipCode();
    }


}