package trelloendtoend;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qsp.trello.genericutility.BaseClass;
import com.qsp.trello.genericutility.FileUtility;
import com.qsp.trello.pomrepo.TrelloBoardsPage;
import com.qsp.trello.pomrepo.TrelloHomePage;
import com.qsp.trello.pomrepo.TrelloLoginPage;
import com.qsp.trello.pomrepo.TrelloLoginToContinuePage;

public class TrelloCreateAndDeleteBoard extends BaseClass {

	@Test
	public void CreateAndDeleteBoard() throws IOException {
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		loginPage.getEmailTextField().sendKeys(fileUtils.readTheDataFromPropertyFile("email"));
		loginPage.getLoginButton().submit();
		TrelloLoginToContinuePage loginToContinuePage = new TrelloLoginToContinuePage(driver);
		//loginToContinuePage.getPasswordTextField().sendKeys(fileUtils.readTheDataFromPropertyFile("password"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(loginToContinuePage.getPasswordTextField())).sendKeys(fileUtils.readTheDataFromPropertyFile("password"));
		loginToContinuePage.getLoginToContinueButton().submit();
        TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
        boardsPage.getCreateNewBoardOption().click();
        boardsPage.getBoardTitle().sendKeys(fileUtils.readTheDataFromPropertyFile("boardtitle"));
        Actions actions = new Actions(driver);
        actions.moveToElement(boardsPage.getCreateButton()).click(boardsPage.getCreateButton()).perform();
	}
}
