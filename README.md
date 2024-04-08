# Integrated Health Finance Management System

The project aims to develop an Integrated Health Finance Management System (IHFMS) for MediCare Uganda Inc. This system will streamline financial operations and enhance internal communication by integrating health information systems with finance, accounts, and messaging functionalities for various healthcare facilities

Notes:
- As soon as an invoice is created, an accounts receivable must be generated (meaning accounts receivable can be implemented as an observer)
- ChatController could implement ChatObserver, and pass into its constructor
  - chatObservable.add(this) to add it as an observer