package map.project.slots.UI;

import map.project.slots.Model.Bar;
import map.project.slots.Model.Cashier;
import map.project.slots.Model.Dto.CashierDto;
import map.project.slots.Model.Dto.Proxy.ProxyAdapter;
import map.project.slots.Service.BarService;
import map.project.slots.Service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class CashierUI {
    @Autowired
    private CashierService cashierService;

    @Autowired
    private BarService barService;

    private final ProxyAdapter proxyAdapter = ProxyAdapter.getInstance();

    @ShellMethod(key = "cashiers")
    public String findAllCashiers() {
        List<CashierDto> cashiers = new ArrayList<>();
        for (Cashier cashier : this.cashierService.findAllCashiers()) {
            cashiers.add((CashierDto) proxyAdapter.adapt(cashier));
        }
        return cashiers.toString();
    }

    @ShellMethod(key = "find cashier")
    public String findCashierById(@ShellOption(value = {"cashierId"}, help = "cashier id") Long cashierId) {
        try {
            return proxyAdapter.adapt(this.cashierService.findCashierById(cashierId)).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "delete cashier")
    public String deleteCashierById(@ShellOption(value = {"cashierId"}, help = "cashier id") Long cashierId) {
        try {
            return proxyAdapter.adapt(this.cashierService.deleteCashierById(cashierId)).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "add cashier")
    public String addCashier(@ShellOption(value = {"name"}, help = "cashier name") String name,
                             @ShellOption(value = {"email"}, help = "cashier email") String email,
                             @ShellOption(value = {"salary"}, help = "cashier salary") float salary,
                             @ShellOption(value = {"bar"}, help = "bar id") Long barId) {
        try {
            Bar bar = this.barService.findBarById(barId);
            Cashier cashier = new Cashier();
            cashier.setName(name);
            cashier.setSalary(salary);
            cashier.setEmail(email);
            cashier.setBar(bar);
            return proxyAdapter.adapt(this.cashierService.addCashier(cashier)).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "update cashier")
    public String updateCashier(@ShellOption(value = {"cashier id"}, help = "cashier id") Long cashierId,
                                @ShellOption(value = {"name"}, help = "cashier name") String name,
                                @ShellOption(value = {"email"}, help = "cashier email") String email,
                                @ShellOption(value = {"salary"}, help = "cashier salary") float salary,
                                @ShellOption(value = {"bar"}, help = "bar id") Long barId){
        try{
            Bar bar = this.barService.findBarById(barId);
            Cashier cashier = new Cashier();
            cashier.setBar(bar);
            cashier.setName(name);
            cashier.setEmail(email);
            cashier.setSalary(salary);
            cashier.setPersonId(cashierId);
            return proxyAdapter.adapt(this.cashierService.updateCashier(cashier)).toString();
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
