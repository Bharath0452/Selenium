package com.qsp.trello.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardsPage {

	WebDriver driver;
	public TrelloBoardsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p/span[text()='Create new board']")
	private WebElement createNewBoardOption;
	
	public WebElement getCreateNewBoardOption() {
		return createNewBoardOption;
	}

	public WebElement getBoardTitle() {
		return boardTitle;
	}

	public WebElement getCreateButton() {
		return createButton;
	}

	@FindBy(xpath = "//input[@data-testid='create-board-title-input']")
	private WebElement boardTitle;
	
	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createButton;
}
