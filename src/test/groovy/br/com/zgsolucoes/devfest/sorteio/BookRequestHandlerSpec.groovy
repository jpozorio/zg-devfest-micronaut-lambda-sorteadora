package br.com.zgsolucoes.devfest.sorteio;
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class BookRequestHandlerSpec extends Specification {

    @AutoCleanup
    @Shared
    SorteioRequestHandler bookRequestHandler = new SorteioRequestHandler()


    void "test Handler"() {
        given:
        Book book = new Book()
        book.name = 'Building Microservices'

        when:
        BookSaved bookSaved = bookRequestHandler.execute(book)

        then: 'book name matches the one supplied'
        bookSaved.name == book.name

        and: 'isbn is populated'
        bookSaved.isbn
    }
}
