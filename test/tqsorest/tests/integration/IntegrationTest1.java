package tqsorest.tests.integration;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tqsorest.main.Client;
import tqsorest.main.DiningRoom;
import tqsorest.main.WaitingRoom;

public class IntegrationTest1 {
	// Test member data
	public WaitingRoom waitingRoom;
	public DiningRoom diningRoom;
	public Client client1;
	public Client client2;
	public Client client3;
	
	@Before
	public void setUp() {
		waitingRoom = new WaitingRoom();
		diningRoom = new DiningRoom(waitingRoom);
		client1 = new Client();
		client2 = new Client();
		client3 = new Client();
	}

	@Test
	public void testEmptyWaitingRoom() {
		assertFalse(diningRoom.pickAClientFromWaitingRoom());
	}
	
	@Test
	public void testWaitingRoom() {
		waitingRoom.clientArrive(client1);
		waitingRoom.clientArrive(client2);
		waitingRoom.clientArrive(client3);
		
		diningRoom.pickAClientFromWaitingRoom();
		assertEquals(1, diningRoom.get_clientsInProgress().size());
	}
}