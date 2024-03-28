package com.esprit.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import java.util.List;


@Service
public class ReservationService {



    @Autowired
    private JavaMailSender mailSender;
    @Autowired

    private ReservationRepository reservationRepository;


    public void sendEmailParametre(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("bestcamp195@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        this.mailSender.send(simpleMailMessage);

    }

        public Reservation createReservation(Reservation reservation) {
            String subject="";
            String message="";
            subject=subject+ "Your Inactivity in BEST CAMP";
            message=message+"Hello "+ reservation.getEmail()+ ",\n" +
                    "\n" +
                    "We hope this email finds you well. "+"\n"+" We wanted to inform you that it has been 15 days since your last visit to BEST CAMP. We wanted to reach out and let you know that we miss you!";
            sendEmailParametre(reservation.getEmail(),subject,message);
            return reservationRepository.save(reservation);
        }

        public Reservation getReservationById(Long id) {
            return reservationRepository.findById(id.intValue()).orElse(null);
        }

        public List<Reservation> getAllReservations() {
            return reservationRepository.findAll();
        }

        public List<Reservation> getReservationsByCentre(Long idCentre) {
            return reservationRepository.findByIdCentre(idCentre);
        }

        public List<Reservation> getReservationsByEvent(Long idEvent) {
            return reservationRepository.findByIdEvent(idEvent);
        }

        public List<Reservation> getReservationsByUser(Long idUser) {
            return reservationRepository.findByIdUser(idUser);
        }

        public Reservation updateReservation(Reservation reservation) {
            return reservationRepository.save(reservation);
        }

        public void deleteReservation(Long id) {
            reservationRepository.deleteById(id.intValue());
        }
    }

