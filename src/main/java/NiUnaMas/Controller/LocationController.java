package NiUnaMas.Controller;

import NiUnaMas.Api.LocationApiDoc;
import NiUnaMas.Controller.Exceptions.UserDoesNotExistException;
import NiUnaMas.Daos.LocationDao;
import NiUnaMas.Daos.UserDao;
import NiUnaMas.Models.*;
import NiUnaMas.Varios.Uris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 11/05/2017.
 */
@RestController
@CrossOrigin
@RequestMapping(Uris.SERVLET_MAP+Uris.USER+Uris.ID+Uris.KEEPALIVE)
public class LocationController implements LocationApiDoc{

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public SuccessfulAction sendKeepAlive( @RequestBody Location location, @PathVariable String id) {
        try{
            User user = userDao.findById(id);
            if(user==null)
                throw new UserDoesNotExistException("");
            else{
                location.setUser_dni(user);
                location.setId(new LocationPK(location.getId().getDate(), user.getDni()));
                locationDao.save(location);
                return new SuccessfulAction("200", "Sent successfuly.");
            }
        }catch(UserDoesNotExistException e){
        throw new UserDoesNotExistException("The user does not exists");
        }
    }




    @Autowired
    private UserDao userDao;
    @Autowired
    private LocationDao locationDao;
}