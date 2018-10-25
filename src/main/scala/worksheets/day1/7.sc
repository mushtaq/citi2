""

sealed trait Day
object Day {
  case object Weekday extends Day
  case object Weekend extends Day
}

sealed trait CustomerType
object CustomerType {
  case object Reward extends CustomerType
  case object Regular extends CustomerType
}

case class BookingType(customerType: CustomerType, day: Day)

case class BookingRequest(customerType: CustomerType, days: List[Day]) {
  def bookingTypes: List[BookingType] = days.map(day => BookingType(customerType, day))
}

case class Hotel(name: String, rating: Int, rates: Map[BookingType, Int]) {
  def getPrice(bookingRequest: BookingRequest): Int = bookingRequest.bookingTypes.map(b => rates(b)).sum
}

class BookingService(hotels: List[Hotel]) {
  def findBestHotel(bookingRequest: BookingRequest): Hotel = hotels.minBy(h => (h.getPrice(bookingRequest), -h.rating))
}
