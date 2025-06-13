package com.greeshwar.BookingManagementSystem.Services;

import com.greeshwar.BookingManagementSystem.Exceptions.UserNotFoundException;
import com.greeshwar.BookingManagementSystem.Models.Ticket;
import com.greeshwar.BookingManagementSystem.Models.User;
import com.greeshwar.BookingManagementSystem.Repositories.TicketRepository;
import com.greeshwar.BookingManagementSystem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }



    public List<Ticket> getAllTickets(String email){
        Optional<User> optionalUser = userRepository.findByEmail(email);



        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("user not found");
        }

        User user = optionalUser.get();

        List<Ticket> tickets = this.ticketRepository.findAllByUser(user);

        return tickets;


    }


    public List<User> allUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
}
