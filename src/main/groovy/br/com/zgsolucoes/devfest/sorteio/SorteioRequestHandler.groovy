package br.com.zgsolucoes.devfest.sorteio

import br.com.zgsolucoes.devfest.micronaut.sorteio.Sorteador
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import io.micronaut.core.annotation.Introspected
import io.micronaut.function.aws.MicronautRequestHandler

@Introspected
class SorteioRequestHandler extends MicronautRequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    APIGatewayProxyResponseEvent execute(APIGatewayProxyRequestEvent input) {
        final String body = input.body
        final Sorteador sorteador = new Sorteador(body)
        final String vencedor = sorteador.sorteiaEAvisa()
        final APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent()
        responseEvent.body = '{"vencedor": "' + vencedor + '"}'
        return responseEvent
    }
}
