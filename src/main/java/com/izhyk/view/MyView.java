package com.izhyk.view;

import com.izhyk.controller.*;
import com.izhyk.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MyView {

    @Autowired
    private HotelController hotelController;
    @Autowired
    private HotelRoomController hotelRoomController;
    @Autowired
    private HotelsBranchController hotelsBranchController;
    @Autowired
    private LocationController locationController;
    @Autowired
    private ReservationController reservationController;
    @Autowired
    private UserController userController;

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner input = new Scanner(System.in);

    private final Hotel nullHotel = new Hotel(null, null, null);
    private final HotelRoom nullHotelRoom = new HotelRoom(null, null, null, null, null);

    private final HotelsBranch nullHotelBranch = new HotelsBranch(null, null, null, null);
    private final Location nullLocation = new Location(null, null, null, null);
    private final Reservation nullReservation = new Reservation(null, null, null, null);
    private final User nullUser = new User(null, null, null, null);

    public MyView() {
        menu = new LinkedHashMap<>();
        menu.put("A", "  A - Select all table");

        menu.put("1", "   1 - Table: Location");
        menu.put("11", "  11 - Create Location");
        menu.put("12", "  12 - Update Location");
        menu.put("13", "  13 - Delete from Location");
        menu.put("14", "  14 - Find all Books");
        menu.put("15", "  15 - Find Location by ID");
        menu.put("16", "  16 - Find Location by country");

        menu.put("2", "   2 - Table: HotelsBranch");
        menu.put("21", "  21 - Create HotelsBranch");
        menu.put("22", "  22 - Update HotelsBranch");
        menu.put("23", "  23 - Delete from HotelsBranch");
        menu.put("24", "  24 - Find all HotelsBranch");
        menu.put("25", "  25 - Find Location by ID");
        menu.put("26", "  26 - Find HotelsBranch by Branch Name");

        menu.put("3", "   3 - Table: Hotel");
        menu.put("31", "  31 - Create Hotel");
        menu.put("32", "  32 - Update Hotel");
        menu.put("33", "  33 - Delete from Hotel");
        menu.put("34", "  34 - Find all Hotel");
        menu.put("35", "  35 - Find Hotel by ID");
        menu.put("36", "  36 - Find all Hotel by Name");

        menu.put("4", "   4 - Table: Hotel Room");
        menu.put("41", "  41 - Create Hotel Room");
        menu.put("42", "  42 - Update Hotel Room");
        menu.put("43", "  43 - Delete from Hotel Room");
        menu.put("44", "  44 - Find all Hotel Rooms");
        menu.put("45", "  45 - Find Hotel Room by ID");
        menu.put("46", "  46 - Find Hotel Room by Number Of Places");


        menu.put("5", "   5 - Table: Reservation");
        menu.put("51", "  51 - Create Reservation");
        menu.put("52", "  52 - Update Reservation");
        menu.put("53", "  53 - Delete from Reservation");
        menu.put("54", "  54 - Find all Reservations");
        menu.put("55", "  55 - Find Reservation by ID");
        menu.put("56", "  56 - Find Reservations by paid");

        menu.put("6", "   6 - Table: User");
        menu.put("61", "  61 - Create User");
        menu.put("62", "  62 - Update User");
        menu.put("63", "  63 - Delete from User");
        menu.put("64", "  64 - Find all User");
        menu.put("65", "  65 - Find User by ID");
        menu.put("66", "  66 - Find all User by last Name");

        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("11", this::createLocation);
        methodsMenu.put("12", this::updateLocation);
        methodsMenu.put("13", this::deleteFromLocation);
        methodsMenu.put("14", this::findAllLocation);
        methodsMenu.put("15", this::findLocationById);
        methodsMenu.put("16", this::findLocationByCountryName);

        methodsMenu.put("21", this::createHotelsBranch);
        methodsMenu.put("22", this::updateHotelsBranch);
        methodsMenu.put("23", this::deleteFromHotelsBranch);
        methodsMenu.put("24", this::findAllHotelsBranch);
        methodsMenu.put("25", this::findHotelsBranchById);
        methodsMenu.put("26", this::findHotelsBranchByName);

        methodsMenu.put("31", this::createHotel);
        methodsMenu.put("32", this::updateHotel);
        methodsMenu.put("33", this::deleteFromHotel);
        methodsMenu.put("34", this::findAllHotels);
        methodsMenu.put("35", this::findHotelById);
        methodsMenu.put("36", this::findHotelByName);

        methodsMenu.put("41", this::createHotelRoom);
        methodsMenu.put("42", this::updateHotelRoom);
        methodsMenu.put("43", this::deleteFromHotelRoom);
        methodsMenu.put("44", this::findAllHotelRooms);
        methodsMenu.put("45", this::findHotelRoomById);
        methodsMenu.put("46", this::findHotelRoomByPlaces);


        methodsMenu.put("51", this::createReservation);
        methodsMenu.put("52", this::updateReservation);
        methodsMenu.put("53", this::deleteFromReservation);
        methodsMenu.put("54", this::findAllReservation);
        methodsMenu.put("55", this::findReservationById);
        methodsMenu.put("56", this::findReservationByPaid);


        methodsMenu.put("61", this::createUser);
        methodsMenu.put("62", this::updateUser);
        methodsMenu.put("63", this::deleteFromUser);
        methodsMenu.put("64", this::findAllUsers);
        methodsMenu.put("65", this::findUserById);
        methodsMenu.put("66", this::findUserByLastName);

    }

    private void selectAllTable() {
        findAllLocation();
        findAllHotelsBranch();
        findAllHotels();
        findAllHotelRooms();
        findAllReservation();
        findAllUsers();
    }

    // region BOOK ---------------------------------------------------
    private void createLocation() {
        System.out.println("Input 'city': ");
        String city = input.nextLine();
        System.out.println("Input 'street': ");
        String street = input.nextLine();
        System.out.println("Input 'country_name': ");
        String countryName = input.nextLine();
        Location location = new Location(null, city, street, countryName);

        int count = locationController.create(location);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateLocation() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new'city': ");
        String city = input.nextLine();
        System.out.println("Input new 'street': ");
        String street = input.nextLine();
        System.out.println("Input new 'country_name': ");
        String countryName = input.nextLine();
        Location location = new Location(null, city, street, countryName);

        int count = locationController.create(location);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromLocation() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = locationController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllLocation() {
        System.out.println("\nTable: LOCATION");
        List<Location> locations = locationController.findAll();
        for (Location location : locations) {
            System.out.println(location);
        }
    }

    private void findLocationById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Location> location = locationController.findById(id);
        System.out.println(location.orElse(nullLocation));
    }

    private void findLocationByCountryName() {
        System.out.println("Input 'country_name': ");
        String countryName = input.nextLine();

        Optional<Location> location = locationController.findByCountry(countryName);
        System.out.println(location.orElse(nullLocation));
    }


    //endregion
    // region HOTELSBRANCH ---------------------------------------------------
    private void createHotelsBranch() {
        System.out.println("Input 'number_of_hotels': ");
        Integer numberOfHotels = Integer.valueOf(input.nextLine());
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'location_id': ");
        Integer locationId = Integer.valueOf(input.nextLine());
        HotelsBranch hotelsBranch = new HotelsBranch(null,numberOfHotels,name,locationId);

        int count = hotelsBranchController.create(hotelsBranch);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateHotelsBranch() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'number_of_hotels': ");
        Integer numberOfHotels = Integer.valueOf(input.nextLine());
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'location_id': ");
        Integer locationId = Integer.valueOf(input.nextLine());
        HotelsBranch hotelsBranch = new HotelsBranch(null,numberOfHotels,name,locationId);

        int count = hotelsBranchController.update(id, hotelsBranch);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromHotelsBranch() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = hotelsBranchController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllHotelsBranch() {
        System.out.println("\nTable: HOTELS_BRANCH");
        List<HotelsBranch> hotelsBranches = hotelsBranchController.findAll();
        for (HotelsBranch hotelsBranche : hotelsBranches) {
            System.out.println(hotelsBranche);
        }
    }

    private void findHotelsBranchById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<HotelsBranch> hotelsBranch = hotelsBranchController.findById(id);
        System.out.println(hotelsBranch.orElse(nullHotelBranch));
    }
    private void findHotelsBranchByName() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();

        Optional<HotelsBranch> hotelsBranch = hotelsBranchController.findByBranchName(name);
        System.out.println(hotelsBranch.orElse(nullHotelBranch));
    }
    // endregion
    // region HOTEL -------------------------------------------------
    private void createHotel() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'hotels_branch_id': ");
        Integer hotelsBranchId = Integer.valueOf(input.nextLine());
        Hotel hotel = new Hotel(null, name, hotelsBranchId);

        int count = hotelController.create(hotel);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateHotel() {

        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'hotels_branch_id': ");
        Integer hotelsBranchId = Integer.valueOf(input.nextLine());
        Hotel hotel = new Hotel(null, name, hotelsBranchId);

        int count = hotelController.update(id, hotel);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromHotel() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = hotelController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllHotels() {
        System.out.println("\nTable: HOTELS");
        List<Hotel> hotels = hotelController.findAll();
        for (Hotel hotel : hotels) {
            System.out.println(hotel);
        }
    }

    private void findHotelById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Hotel> hotel = hotelController.findById(id);
        System.out.println(hotel.orElse(nullHotel));
    }

    private void findHotelByName() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();

        Optional<Hotel> hotel = hotelController.findByHotelName(name);
        System.out.println(hotel.orElse(nullHotel));
    }
    //endregion

    // region HOTEL ROOM ---------------------------------------------------
    private void createHotelRoom() {
        System.out.println("Input 'number_of_places': ");
        Integer numberOfPlaces = Integer.valueOf(input.nextLine());
        System.out.println("Input 'is_free': ");
        Boolean isFree = Boolean.valueOf(input.nextLine());
        System.out.println("Input 'price': ");
        Integer price = Integer.valueOf(input.nextLine());
        System.out.println("Input 'hotel_id': ");
        Integer hotelId = Integer.valueOf(input.nextLine());

        HotelRoom hotelRoom = new HotelRoom(null, numberOfPlaces, isFree, price,hotelId);

        int count = hotelRoomController.create(hotelRoom);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateHotelRoom() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'number_of_places': ");
        Integer numberOfPlaces = Integer.valueOf(input.nextLine());
        System.out.println("Input 'is_free': ");
        Boolean isFree = Boolean.valueOf(input.nextLine());
        System.out.println("Input 'price': ");
        Integer price = Integer.valueOf(input.nextLine());
        System.out.println("Input 'hotel_id': ");
        Integer hotelId = Integer.valueOf(input.nextLine());

        HotelRoom hotelRoom = new HotelRoom(null, numberOfPlaces, isFree, price,hotelId);

        int count = hotelRoomController.update(id, hotelRoom);
        System.out.printf("There are updated %d rows\n", count);

    }

    private void deleteFromHotelRoom() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = hotelRoomController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }


    private void findAllHotelRooms() {
        System.out.println("\nTable: HOTEL_ROOM");
        List<HotelRoom> hotelRooms = hotelRoomController.findAll();
        for (HotelRoom hotelRoom : hotelRooms) {
            System.out.println(hotelRoom);
        }
    }

    private void findHotelRoomById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<HotelRoom> hotelRoom = hotelRoomController.findById(id);
        System.out.println(hotelRoom.orElse(nullHotelRoom));
    }

    private void findHotelRoomByPlaces() {
        System.out.println("Input 'number_of_places': ");
        Integer numberOfPlaces = Integer.valueOf(input.nextLine());

        Optional<HotelRoom> hotelRoom = hotelRoomController.findByNumberOfPlaces(numberOfPlaces);
        System.out.println(hotelRoom.orElse(nullHotelRoom));
    }
    //endregion



    // region RESERVATION ---------------------------------------------------
    private void createReservation() {
        System.out.println("Input 'days_of_reservation': ");
        Integer daysOfReservation = Integer.valueOf(input.nextLine());
        System.out.println("Input 'is_paid': ");
        Boolean isPaid = Boolean.valueOf(input.nextLine());
        System.out.println("Input 'hotel_room_id': ");
        Integer hotelRoomId = Integer.valueOf(input.nextLine());

        Reservation reservation = new Reservation(null, daysOfReservation, isPaid, hotelRoomId);

        int count = reservationController.create(reservation);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateReservation() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'days_of_reservation': ");
        Integer daysOfReservation = Integer.valueOf(input.nextLine());
        System.out.println("Input 'is_paid': ");
        Boolean isPaid = Boolean.valueOf(input.nextLine());
        System.out.println("Input 'hotel_room_id': ");
        Integer hotelRoomId = Integer.valueOf(input.nextLine());

        Reservation reservation = new Reservation(null, daysOfReservation, isPaid, hotelRoomId);

        int count = reservationController.update(id, reservation);
        System.out.printf("There are updated %d rows\n", count);

    }
    private void deleteFromReservation() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = reservationController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllReservation() {
        System.out.println("\nTable: RESERVATION");
        List<Reservation> reservations = reservationController.findAll();
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    private void findReservationById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Reservation> reservation = reservationController.findById(id);
        System.out.println(reservation.orElse(nullReservation));
    }
    private void findReservationByPaid() {
        System.out.println("Input 'is_paid': ");
        Boolean isPaid = Boolean.valueOf(input.nextLine());

        Optional<Reservation> reservation = reservationController.findPaid(isPaid);
        System.out.println(reservation.orElse(nullReservation));
    }
    //endregion



    // region USER ---------------------------------------------------
    private void createUser() {
        System.out.println("Input 'first_name': ");
        String firstName = input.nextLine();
        System.out.println("Input 'last_name': ");
        String lastName = input.nextLine();
        System.out.println("Input 'reservation_id': ");
        Integer reservationId = Integer.valueOf(input.nextLine());
        User user = new User(null, firstName, lastName, reservationId);

        int count = userController.create(user);
        System.out.printf("There are created %d rows\n", count);
    }
    private void updateUser() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'first_name': ");
        String firstName = input.nextLine();
        System.out.println("Input 'last_name': ");
        String lastName = input.nextLine();
        System.out.println("Input 'reservation_id': ");
        Integer reservationId = Integer.valueOf(input.nextLine());
        User user = new User(null, firstName, lastName, reservationId);

        int count = userController.update(id, user);
        System.out.printf("There are updated %d rows\n", count);

    }
    private void deleteFromUser() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = userController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllUsers() {
        System.out.println("\nTable: USER");
        List<User> users = userController.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
    private void findUserById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<User> user = userController.findById(id);
        System.out.println(user.orElse(nullUser));
    }
    private void findUserByLastName() {
        System.out.println("Input 'last_name': ");
        String lastName = input.nextLine();

        Optional<User> user = userController.findByUserLastName(lastName);
        System.out.println(user.orElse(nullUser));
    }
    //endregion
    //-------------------------------------------------------------------------
    // region output
    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!keyMenu.equals("Q"));
    }

    //endregion
}

