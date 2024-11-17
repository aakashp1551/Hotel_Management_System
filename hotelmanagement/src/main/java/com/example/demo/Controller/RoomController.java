package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.RoomRepository;
import com.example.demo.entity.Room;

@RestController
	@RequestMapping("/rooms")
	public class RoomController {

	    @Autowired
	    private RoomRepository roomRepository;

	    @GetMapping
	    public List<Room> getAllRooms() {
	        return roomRepository.findAll();
	    }

	    @PostMapping
	    public Room createRoom(@RequestBody Room room) {
	        return roomRepository.save(room);
	    }

	    @GetMapping("/{id}")
	    public Room getRoomById(@PathVariable Long id) {
	        return roomRepository.findById(id).orElseThrow();
	    }

	    @PutMapping("/{id}")
	    public Room updateRoom(@PathVariable Long id, @RequestBody Room room) {
	        room.setId(id);
	        return roomRepository.save(room);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteRoom(@PathVariable Long id) {
	        roomRepository.deleteById(id);
	    }

}
