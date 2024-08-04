package com.adeprogramming.universalpetcare.controller;

import com.adeprogramming.universalpetcare.dto.EntityConverter;
import com.adeprogramming.universalpetcare.dto.UserDto;
import com.adeprogramming.universalpetcare.exception.ResourceNotFoundException;
import com.adeprogramming.universalpetcare.exception.UserAlreadyExistsException;
import com.adeprogramming.universalpetcare.model.User;
import com.adeprogramming.universalpetcare.request.UserUpdateRequest;
import com.adeprogramming.universalpetcare.response.ApiResponse;
import com.adeprogramming.universalpetcare.request.RegistrationRequest;
import com.adeprogramming.universalpetcare.service.user.UserService;
import com.adeprogramming.universalpetcare.utils.FeedBackMessage;
import com.adeprogramming.universalpetcare.utils.UrlMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;


@RequiredArgsConstructor
@RequestMapping(UrlMapping.USERS)
@RestController
public class UserController {



    private final UserService userService;
    private final EntityConverter<User, UserDto>entityConverter;


    @PostMapping(UrlMapping.REGISTER_USER)
    public ResponseEntity<ApiResponse> add(@RequestBody RegistrationRequest request) {
        try {
            User theUser = userService.add(request);
            UserDto registeredUser = entityConverter.mapEntityToDto(theUser, UserDto.class);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.SUCCESS, registeredUser));
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(), null));
        }catch(Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }

        }

        @PutMapping(UrlMapping.UPDATE_USER)

        public ResponseEntity<ApiResponse>update(@PathVariable Long userId, @RequestBody UserUpdateRequest request) {
            try{
                User theUser = userService.update(userId, request);
                UserDto updateUser = entityConverter.mapEntityToDto(theUser, UserDto.class);
                return ResponseEntity.ok(new ApiResponse(FeedBackMessage.UPDATE_SUCCESS, updateUser));

            }catch(ResourceNotFoundException e){
                return  ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));

            }catch (Exception e) {
                return  ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
            }

        }

        @GetMapping(UrlMapping.GET_USER_BY_ID)
        public ResponseEntity<ApiResponse> findById(@PathVariable Long userId) {
           try {
                  User user = (User) userService.findById(userId);
                   UserDto theUser = entityConverter.mapEntityToDto(user, UserDto.class);
                   return ResponseEntity.status(FOUND).body(new ApiResponse(FeedBackMessage.FOUND, theUser));

           } catch (ResourceNotFoundException e) {
               return  ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));

           }catch (Exception e) {
               return  ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
            }
        }

        @DeleteMapping(UrlMapping.DELETE_USER_BY_ID)
        public  ResponseEntity<ApiResponse>deleteById(@PathVariable Long userId) {
        try {
            userService.delete(userId);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.DELETE_SUCCESS, null));
        } catch (ResourceNotFoundException e) {
            return  ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }catch(Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
        }

        @GetMapping(UrlMapping.GET_ALL_USERS)
        public  ResponseEntity<ApiResponse> getAllUsers() {
            List<UserDto> theUsers = userService.getAllUsers();
            return ResponseEntity.status(FOUND).body(new ApiResponse(FeedBackMessage.FOUND, (UserDto) theUsers));
        }

    }
