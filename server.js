const mysql = require("mysql");
const express = require("express");
const dotenv = require("dotenv");
const bodyParser = require("body-parser");
const router = require("./routes/tasks");
const cors = require("cors");
const Eureka = require("eureka-js-client").Eureka;

const app = express();

app.use(cors());

app.use(bodyParser.json({ limit: "30mb", extended: true }));
app.use(bodyParser.urlencoded({ extended: true }));

Eureka.fetchRegistry = false;
Eureka.registerWithEureka = false;
const client = new Eureka({
  // application instance information
  instance: {
    app: "jqservice",
    hostName: "localhost",
    ipAddr: "127.0.0.1",
    port: 4000,
    vipAddress: "jq.test.something.com",
    dataCenterInfo: {
      name: "Mahdi",
    },
  },
  eureka: {
    // eureka server host / port
    host: "192.168.99.100",
    port: 32768,
  },
});
client.start();
const db = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "",
  database: "smartdelivery",
});

db.connect((err) => {
  if (err) {
    console.log(err);
  }
});

app.listen("5000", () => {
  console.log("server listening on Port 5000");
});

app.post("/paquet/Add", (req, res) => {
  let task = req.body;
  console.log("body: ", req.body);
  let sql = "INSERT INTO paquet SET ?";
  db.query(sql, task, (err, result) => {
    if (err) {
      console.log(err);
    }
    console.log(result);
    res.send("paquet added");
  });
});

app.get("/paquet", (req, res) => {
  let sql = "SELECT * FROM paquet";
  let query = db.query(sql, (err, result) => {
    if (err) {
      console.log(err);
    }
    res.json(result);
  });
});

app.get("/paquet/:id", (req, res) => {
  let sql = `SELECT * FROM paquet WHERE id = ${req.params.id}`;
  db.query(sql, (err, result) => {
    if (err) {
      console.log(err);
    }
    res.json(result);
    console.log(result);
  });
});

app.patch("/paquet/update/:id", (req, res) => {
  let newTask = req.body;
  console.log(newTask);
  let sql = `UPDATE paquet SET ? WHERE id = ${req.params.id}`;
  let query = db.query(sql, newTask, (err, result) => {
    if (err) {
      console.log(err);
    }
    console.log(result);
    res.send("paquet with id: " + req.params.id + " updated");
  });
});

app.get("/paquet/delete/:id", (req, res) => {
  let sql = `DELETE FROM paquet WHERE id = ${req.params.id}`;
  let query = db.query(sql, (err, result) => {
    if (err) {
      console.log(err);
    }
    console.log(result);
    res.send("paquet with id: " + req.params.id + " deleted");
  });
});
