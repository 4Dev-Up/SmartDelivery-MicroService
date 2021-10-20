const DeliveryMan = require("../model/DeliveryMan");

module.exports = (app) => {
    const Delivery_Man = require("../model/DeliveryMan");
  // GET all DeliveryMans
  app.get("/Delivery_Man", async function (req, res, next) {
    await Delivery_Man.find(function (err, data) {
      if (err) {
        console.log(err);
      }
      res.json(data);
    });
  });
 // GET DeliveryMan by id
 app.get("/Delivery_Man/:id", async function (req, res, next) {
    var id = req.params.id;
    await Delivery_Man.findById(id, function (err, data) {
      if (err) {
        console.log(err);
      }
      res.json(data);
    });
  });

  // add DeliveryMan
  app.post("/Delivery_Man/add", async function (req, res) {
    var Delivery_Man = new DeliveryMan();
    Delivery_Man.Id = req.body.Id;
    Delivery_Man.Nom = req.body.Nom;
    Delivery_Man.Phone_number = req.body.Phone_number;
    Delivery_Man.Adress = req.body.Adress;
    try {
      var DeliveryManlog = await Delivery_Man.save();
      console.log(DeliveryManlog);
      res.send("DeliveryMan added");
    } catch (err) {
      console.log(err);
    }
  });

  // delete DeliveryMan
  app.delete("/Delivery_Man/delete/:id", async function (req, res) {
    var id = req.params.id;
    await Delivery_Man.findByIdAndRemove(id, function (err, doc) {
      if (err) {
        console.log(err);
      }
      res.send("DeliveryMan removed");
    });
  });

  // update DeliveryMan
   app.put("/Delivery_Man/update/:id", async function (req, res) {
    var id = req.params.id;
    await Delivery_Man.findByIdAndUpdate(id, { $set: req.body }, function (err, doc) {
      if (err) {
        console.log(err);
      }
      res.send("DeliveryMan updated");
      console.log(doc);
    });
  });

};





