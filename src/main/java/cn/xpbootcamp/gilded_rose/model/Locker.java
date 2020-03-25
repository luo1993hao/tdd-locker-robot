package cn.xpbootcamp.gilded_rose.model;

import cn.xpbootcamp.gilded_rose.exception.FetchPackageException;
import cn.xpbootcamp.gilded_rose.exception.StorePackageException;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Locker {
    private int availableCapacity;
    private int totalCapacity;
    private List<Pair<Ticket, Package>> storeTicketPackages;

    public Locker(int totalCapacity) {
        this.availableCapacity = totalCapacity;
        this.totalCapacity = totalCapacity;
        this.storeTicketPackages = new ArrayList<>();
    }

    public Ticket store(Package beStoredPackage) {
        if (this.availableCapacity <= 0) {
            throw new StorePackageException("locker is full");
        }
        this.availableCapacity = this.availableCapacity - 1;
        //todo bad smell
        Ticket ticket = new Ticket();
        storeTicketPackages.add(new Pair<>(ticket, beStoredPackage));
        return ticket;
    }

    public int getAvailableCapacity() {
        return this.availableCapacity;

    }

    public void fetch(Ticket packageTicket) {
        this.checkTicket(packageTicket);
        Optional<Package> packageOptional = this.storeTicketPackages.stream().filter(x -> x.getKey().getId().equals(packageTicket.getId())).map(Pair::getValue).findFirst();
        if (packageOptional.isPresent()) {
            this.availableCapacity = this.availableCapacity + 1;
            this.storeTicketPackages.remove(new Pair<>(packageTicket, packageOptional.get()));
        } else {
            throw new FetchPackageException("illegal ticket");
        }


    }

    private void checkTicket(Ticket packageTicket) {
        if (this.storeTicketPackages.stream().map(x -> x.getKey().getId().equals(packageTicket.getId())).count() > 1) {
            throw new FetchPackageException("system error,one ticket for more than one package");
        }
    }
}
