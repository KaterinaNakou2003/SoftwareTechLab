class Library:
    
    def __init__(self):
        self.i = 0 
        self.books = dict()

    def find_book(self, title = None, writer = None):
        if title:
            for book,obj in self.books.items():
                if obj["title"] == title:
                    return book
            return 0
        elif writer:
            for book,obj in self.books.items():
                if obj["writer"] == writer:
                    return book
            return 0
        else:
            return 0

    def read_book(self, title = None, writer = None):
        if self.find_book(self, title = None, writer = None) == 0:
            print("We could not find the book. Please try again...")
        else:
            id = self.find_book(self, title, writer)
            publish_date = self.books[id].get("publish_date")
            summary = self.books[id].get("summary")
            if title:
                writer = self.books[id].get("writer")
            elif writer:
                self.books[id].get("title")
            print("Here are the information about the book")
            print("Title: " + title)
            print("Writer: " + writer)
            print("Date published: " + publish_date)
            print("Summary: " + summary)
            
    def delete_book(self, title = None, writer = None):
        if self.find_book(self, title = None, writer = None) == 0:
            return 0
        else:
            self.books.pop(id)
            return 1
    
    def update_book(self,id):
        print("Do you want to change the title? yes/no")
        answer = input()
        if answer == "yes":
            print("Enter title!")
            title= input()
            self.books[id].update({"title": title})
        print("Do you want to change the writer? yes/no")
        if answer == "yes":
            print("Enter writer!")
            writer = input()
            self.books[id].update({"writer": writer})
        print("Do you want to change the date of publishment? yes/no")
        if answer == "yes":
            print("Enter date!")
            publish_date = input()
            self.books[id].update({"publish_date": publish_date})
        print("Do you want to change the summary? yes/no")
        if answer == "yes":
            print("Enter summary!")
            summary = input()
            self.books[id].update({"summary": summary})


    def add_book(self):
        self.i = self.i+1
        id = self.i
        print("Add the title of the book:")
        title = input()
        print("Add the writer of the book:")
        writer = input()        
        print("Add the date that the book was published of the book:")
        publish_date = input()
        print("Add the summary of the book:")
        summary = input()
        self.books[id]= {"title": title, 
                         "writer" : writer, 
                         "publish_date" : publish_date, 
                         "summary" : summary
                        }

    def menu(self):
        flag = True
        while flag:
            print("The menu is:")
            print("1. Read book")
            print("2. Add a new book")
            print("3. Update a book")
            print("4. Delete a book")
            print("5. exit")
            print("Please press a number!!")
            number = input()
            if isinstance(number,int) and number == 1:
                print("Please enter the 1 to enter the title or 2 to enter the writer of the book")
                nu = int(input())
                if isinstance(number,int) and number == 1:
                    print("Please enter the title of the book:")
                    title = input()
                    self.read_book(self, title, None)
                elif isinstance(number,int) and number == 2:
                    print("Please enter the writer of the book:")
                    writer = input()
                    self.read_book(self, None, writer)
                else:
                    print("There has been an error. Please try again!")
                    self.menu(self)
            elif isinstance(number,int) and number == 2:
                self.add_book(self)
            elif isinstance(number,int) and number == 3:
                print("Please enter the 1 to enter the title or 2 to enter the writer of the book you want to update")
                nu = int(input())
                if isinstance(number,int): 
                    if number == 1:
                        print("Please enter the title of the book:")
                        title = input()
                        id = self.find_book(self, title, None)
                    elif number == 2:
                        print("Please enter the writer of the book:")
                        writer = input()
                        id = self.find_book(self, None, writer)
                    if id == 0:
                        print("There has been an error. Please try again!")
                        self.menu(self)
                    else:
                        self.update_book(self,id)
                else:
                    print("There has been an error. Please try again!")
                    self.menu(self)
            elif isinstance(number,int) and number == 4:
                print("Please enter the 1 to enter the title or 2 to enter the writer of the book")
                nu = int(input())
                if isinstance(number,int) and number == 1:
                    print("Please enter the title of the book:")
                    title = input()
                    if ( self.delete_book(self, title, None) == 0) :
                        print("Could not delete the book!")
                    else:
                        print("Book deleted succesfully!")
                elif isinstance(number,int) and number == 2:
                    print("Please enter the writer of the book:")
                    writer = input()
                    self.delete_book(self, None, writer)
                else:
                    print("There has been an error. Please try again!")
                    self.menu(self)
            elif isinstance(number,int) and number == 5:
                print("Exiting...")
                flag = False
            else:
                print("There has been an error. Please try again!")
                self.menu(self) 


library = Library()
library.menu()