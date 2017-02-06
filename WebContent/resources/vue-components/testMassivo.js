/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var loteURL = "/fulltestAPI/lote/massivo/";
var instanciaURL = "/fulltestAPI/instancia/massivo/";
new Vue({
    el: "#massivo",
    data: {
        lotes: null,
        adcLote: {
            id: null,
            status: null,
            observacao: "Teste",
            matricula: null
        },
        delLote: {
            id: null,
            status: null,
            observacao: null,
            matricula: null
        },
        viewLote: {
            id: null,
            dataCriacao: null,
            matricula: null,
            observacao: null,
            status: null,
            tests: []
        },
        countInfo: {
            ativo: 0,
            execucao: 0,
            concluido: 0,
            excluido: 0
        },
        // instancias: "7530301249;7130520294;1630143618;8531030639;7930272843;3125714804",
        instancias: "7530301249;7130520294",
        delimiter: ";"
    },
    created: function() {
        var self = this;
        self.getLotes();
    },
    methods: {
        dateFormat: function(h) {
            return moment(h).format('DD/MM/YYYY');
        },
        //Export
        exporty: function() {
            var self = this;
            window.location.href = "http://localhost:8080/fulltestAPI/testecliente/" + self.viewLote.id;
        },
        //LIST
        getLotes: function() {
            var self = this;
            $.get(loteURL + "ativos", function(data) {
                self.lotes = data.list;
                self.lotes = _.orderBy(self.lotes, ['dataCriacao'], ['asc']);
            });
        },
        //ADC
        createLote: function() {
            var self = this;
            $.ajax({
                type: "POST",
                url: loteURL + "cadastrar",
                data: JSON.stringify(self.adcLote),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function(data) {
                    self.fetchLotes();
                    self.createListaLinhas(data.lote);
                }
            });
        },
        createListaLinhas: function(h) {
            var self = this;
            var listI = self.instancias.split(self.delimiter);
            var lt = h;
            lt.tests = [];
            for (var i = 0; i < listI.length; i++) {
                lt.tests.push({id: null, status: "ATIVO", instancia: listI[i], lote: {id: h.id}});
            }
            $.ajax({
                type: "POST",
                url: loteURL + "modificar",
                data: JSON.stringify(lt),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function() {
                    self.reset();
                    $("#adcLote").modal("hide");
                }
            });
            //console.log(lt);
        },
        //Exclui
        deleLote: function() {
            var self = this;
            $.ajax({
                type: "POST",
                url: loteURL + "excluir",
                data: JSON.stringify(self.delLote),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function() {
                    self.reset();
                    self.getLotes();
                    $("#delLote").modal("hide");
                }
            });
        },
        fetchLotes: function() {
            var self = this;
            setTimeout(function() {
                self.getLotes();
            }, 600);
        },
        fetchLoteDel: function(h) {
            var self = this;
            self.delLote = h;
        },
        fetchLoteEdit: function(h) {
            var self = this;
            self.viewLote = h;

            self.infoLoteCount();
        },
        //Reset Objects
        infoLoteCount: function() {
            var self = this;
            var ins = self.viewLote.tests;
            for (var i = 0; i < ins.length; i++) {
                if (ins[i]["status"] === "ATIVO") {
                    self.countInfo.ativo++;
                } else if (ins[i]["status"] === "EM_EXECUCAO") {
                    self.countInfo.execucao++;
                } else if (ins[i]["status"] === "CONCLUIDO") {
                    self.countInfo.concluido++;
                } else if (ins[i]["status"] === "EXCLUIDO") {
                    self.countInfo.excluido++;
                }
            }
            //console.log(JSON.stringify(self.countInfo));
        },
        reset: function() {
            var self = this;
            self.adcLote = {
                id: null,
                status: null,
                observacao: null,
                matricula: null
            };
            self.delLote = {
                id: null,
                status: null,
                observacao: null,
                matricula: null
            };
            self.countInfo = {
                ativo: 0,
                execucao: 0,
                concluido: 0,
                excluido: 0
            };
            self.viewLote = {
                id: null,
                dataCriacao: null,
                matricula: null,
                observacao: null,
                status: null,
                tests: []
            };
            self.instancias = null;
            self.delimiter = null;
        }
    }
});