package tqsorest.tests.unit;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import tqsorest.main.Client;
import tqsorest.main.WaitingRoom;

public class WaitingRoomTest {
	// Test member data
	public WaitingRoom waitingRoom;
	public Client client1;
	public Client client2;
	public Client client3;
	
	@Before
	public void setUp() {
		waitingRoom = new WaitingRoom();
		client1 = new Client();
		client2 = new Client();
		client3 = new Client();
		
		waitingRoom.clientArrive(client1);
		waitingRoom.clientArrive(client2);
	}
	
	@Test
	public void testClientQueueSize() {
		assertEquals("Test Get Client Size Method", 2, waitingRoom.getClientsNumber());
	}
	
	@Test
	public void testClientArrive() {
		waitingRoom.clientArrive(client3);
		assertEquals("Test Client Arrive Method", 3, waitingRoom.getClientsNumber());
	}
	
	@Test
	public void testServeClient() {
		waitingRoom.serveClient();
		assertEquals("Test Serve Client Method", 1, waitingRoom.getClientsNumber());
	}
}
