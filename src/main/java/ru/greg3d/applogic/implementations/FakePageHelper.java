package ru.greg3d.applogic.implementations;

import ru.greg3d.applogic.interfaces.IFakePageHelper;

public class FakePageHelper extends DriverBasedHelper implements IFakePageHelper{

	private ApplicationManager manager;

	public FakePageHelper(ApplicationManager manager) {
		super(manager.getWebDriver());
		this.manager = manager;
	}

	public void testBlockTrack(){
		pages.fakePage.getBlock().getTrack().moveDown();
		//pages.fakePage.getTrack().moveDown();
	}
	
	public void testTrack(){
		pages.fakePage.getTrack().moveDown();
	}
}
