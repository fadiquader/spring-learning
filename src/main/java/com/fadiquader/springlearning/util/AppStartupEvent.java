package com.fadiquader.springlearning.util;

import com.fadiquader.springlearning.data.Room;
import com.fadiquader.springlearning.data.RoomRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// Wait till spring is done building and ready to do work before we go query the database
@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final RoomRepository roomRepository;

    public AppStartupEvent(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        rooms.forEach(System.out::println);
    }
}
