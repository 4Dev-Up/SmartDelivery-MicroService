const mongoose = require("mongoose");
const Schema = mongoose.Schema;
var DeliveryMan = new Schema({
  Id: Number,
  Name: String,
  Phone_number: Number,
  Adress: String,
});
module.exports = mongoose.model("Delivery_Man", DeliveryMan);
