package com.ondetemjogo.business;

import java.util.List;
import com.ondetemjogo.model.*;

public interface EstablishmentService {

	List<Establishment> getEstablishments(String search);

}
