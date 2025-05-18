package com.greeshwar.BookingManagementSystem.Services;

import com.greeshwar.BookingManagementSystem.Exceptions.UserNotFoundException;
import com.greeshwar.BookingManagementSystem.Models.Ticket;
import com.greeshwar.BookingManagementSystem.Models.User;
import com.greeshwar.BookingManagementSystem.Repositories.TicketRepository;
import com.greeshwar.BookingManagementSystem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private TicketRepository ticketRepository;

    public UserServiceImpl(UserRepository userRepository
                          ){
        this.userRepository = userRepository;
//        this.bCryptPasswordE/ncoder = bCryptPasswordEncoder;
    }

    public User signup(String name, String email, String password){
        //validate if the email is already registered

        Optional<User> optionalUser = userRepository.findByEmail(email);

        User savedUser = null;

        if(optionalUser.isPresent()){
            throw new RuntimeException("User with this email " + email + " is already registered");
            //ask the user to login, user with this email is already registered.
        }else{
            User user = new User();
            user.setEmail(email);
            user.setName(name);
            //encrypt the password and store the encyrpted password in the db
//            user.setPassword(bCryptPasswordEncoder.encode(password));
            user.setPassword(password);
            savedUser = userRepository.save(user);
        }

        return savedUser;

    }

    public List<Ticket> getAllTickets(Long userId){
        Optional<User> optionalUser = userRepository.findById(userId);



        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("user not found");
        }

        User user = optionalUser.get();

        List<Ticket> tickets = this.ticketRepository.findAllByUser(user);

        return tickets;


    }
}
