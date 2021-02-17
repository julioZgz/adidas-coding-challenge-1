package org.julio.gregorio.adidas.subscription.service.util;

import javax.validation.Valid;

import org.julio.gregorio.adidas.subscription.service.dto.EmailRequestDTO;
import org.springframework.scheduling.annotation.Async;

public interface EmailSenderIface {

	@Async
	public void sendEmail(@Valid EmailRequestDTO emailRequestDTO);

}
