package logic;

import data.Beam;
import data.Carport;
import data.CompleteCupCake;
import data.Customer;
import data.DataAccessor;
import data.DataUpdater;
import data.Floor;
import java.util.List;
import data.Material;
import data.Offer;
import data.OfferLine;
import data.Rafter;
import data.Roof;
import data.Shed;
import data.WoodPost;

public class Calculate {
    
    private Material  shoppingcart = new Material();
    
    private Shed shed = new Shed();
    private Roof roof = new Roof();
    private Rafter rafter = new Rafter();
    private OfferLine offerline = new OfferLine();
    private Offer offer = new Offer();
    private Material material = new Material();
    private Floor floor = new Floor();
    private DataUpdater dataupdater = new DataUpdater();
    private Customer customer = new Customer();
    private Carport carport = new Carport();
    private Beam beam = new Beam();
    private DataAccessor dataaccessor = new DataAccessor();
    
    // roof. length 0,8 + 0,3 
    
          
    public double WoodPostNeeded(Carport carport) {
        // hvis tiden tillader, så skal l1, l2 og l3 kunne ændres ved hjælp af database
        
    private WoodPost woodpost = new WoodPost(carport.getRoof().);
    int l = carport.getLength();
    int l1 = 3000;
    int l2 = 800;
    int l3 = 300;
    int TotalPosts = (l - (l2 + l3)) / l1;


    } 
    