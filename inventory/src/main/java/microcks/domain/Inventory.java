package microcks.domain;

import microcks.InventoryApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;


@Entity
@Table(name="Inventory_table")
@Data

//<<< DDD / Aggregate Root
public class Inventory  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    private Long id;
    
    
    
    
    private Integer stock;

    @PostPersist
    public void onPostPersist(){
    }

    public static InventoryRepository repository(){
        InventoryRepository inventoryRepository = InventoryApplication.applicationContext.getBean(InventoryRepository.class);
        return inventoryRepository;
    }

    public void decrease stock(){
        //
    }


//<<< Clean Arch / Port Method
    public void decreaseStock(DecreaseStockCommand decreaseStockCommand){
        
        //implement business logic here:
        
        StockDecreased stockDecreased = new StockDecreased(this);
        stockDecreased.publishAfterCommit();

    }
//>>> Clean Arch / Port Method



}
//>>> DDD / Aggregate Root
