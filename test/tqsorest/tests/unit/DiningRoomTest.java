package tqsorest.tests.unit;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import tqsorest.main.Client;
import tqsorest.main.DiningRoom;
import tqsorest.main.WaitingRoom;

public class DiningRoomTest {
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
	public void testEndAClientServiceInWaintingRoom() {
		diningRoom.addClient(client1);
		diningRoom.addClient(client2);
		assertEquals(2, diningRoom.get_clientsInProgress().size());
		
		diningRoom.removeClient(client2);
		assertEquals(1, diningRoom.get_clientsInProgress().size());
		
		diningRoom.endAClientServiceInWaintingRoom(client1);
		assertEquals(0, diningRoom.get_clientsInProgress().size());
	}
}

