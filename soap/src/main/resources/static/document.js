/**
 * Список всех док черех soap
 */
function listDocumentSoap(){
    $(document.getElementById("allSoap")).on( "click",function(){
    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'https://localhost:8088/ws' );
    var sr = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gen="com/itrail/soap/genereated/documents">' +
            '   <soapenv:Header/> ' +
            '     <soapenv:Body> ' +
            '       <gen:getDocumentRequestFindAll/> ' +
            '     </soapenv:Body> ' +
            '   </soapenv:Envelope>';
    xhr.withCredentials = true;
    xhr.setRequestHeader('Content-Type', 'text/xml');
    xhr.send(sr);
    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4) {                  
            if (xhr.status == 200) {
                var xmlDoc = $.parseXML( xhr.responseText );
                $xml = $( xmlDoc );
                value= $xml.find( "ListResponse" );
                var tr=[];
                tab = value.find("listDocument");
                for (var i = 0; i < tab.length; i++) {
                    tr.push('<tr>');
                    tr.push('<td>' + value.find("ns2\\:id_document")[i].childNodes[0].nodeValue + '</td>');
                    tr.push('<td>' + value.find("ns2\\:type_document")[i].childNodes[0].nodeValue + '</td>');
                    tr.push('<td>' + value.find("ns2\\:seria")[i].childNodes[0].nodeValue + '</td>');
                    tr.push('<td>' + value.find("ns2\\:numar")[i].childNodes[0].nodeValue + '</td>');
                    tr.push('<td>' + value.find("ns2\\:snils")[i].childNodes[0].nodeValue + '</td>');
                    tr.push('<td>' + value.find("ns2\\:polis")[i].childNodes[0].nodeValue + '</td>');
                    tr.push('</tr>');
                }
                $("tr").not(":first").hide();
                $('table').append($(tr.join('')));                
            } else {                               
                console.log("Server сode: ", xhr.status );
    
            }
        }
    };
    });
};
/**
 * Список всех док черех rest
 */
function listDocumentRest(){
    $(document.getElementById("allRest")).on( "click",function(){
        $.getJSON('https://localhost:8082/web/documents/list', function(json) {
            var tr=[];
            for (var i = 0; i < json.length; i++) {
                tr.push('<tr>');
                tr.push('<td>' + json[i].idDocument + '</td>');
                tr.push('<td>' + json[i].typeDocument + '</td>');
                tr.push('<td>' + json[i].seria + '</td>');
                tr.push('<td>' + json[i].numar + '</td>');
                tr.push('<td>' + json[i].snils + '</td>');
                tr.push('<td>' + json[i].polis + '</td>');
                tr.push('</tr>');
                }
                $("tr").not(":first").hide();
                $('table').append($(tr.join('')));
            });
        });
};
/**
 * очистка таблицы
 */
function tableClear(){  
    $(document.getElementById("allСlear")).on( "click",function(){
       $("tr").not(":first").hide();
    });

};
/**
 * Поиск по ид for soap
 */
function findByIdDocument(){
    $(document.getElementById("findById")).on( "click",function(){
        var word = $('#idDocument').val();
        let xhr = new XMLHttpRequest();
        xhr.open('POST', 'https://localhost:8088/ws' );
        sr = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gen="com/itrail/soap/genereated/documents">'+
            '   <soapenv:Header/>'+
            '   <soapenv:Body>'+
            '	  <gen:getDocumentRequestFindById>'+
            '		 <gen:id_document> ' + word +'</gen:id_document>'+
            '	  </gen:getDocumentRequestFindById>'+
            '   </soapenv:Body>'+
            '</soapenv:Envelope>';
        xhr.withCredentials = true;
        xhr.setRequestHeader('Content-Type', 'text/xml');
        xhr.send(sr);
        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4) {                  
                if (xhr.status == 200) {                
                    var xmlDoc = $.parseXML( xhr.responseText );
                    $xml = $( xmlDoc );
                    value= $xml.find( "GetDocumentResponse" );
                    var tr=[];
                    for (var i = 0; i < value.length; i++) {
                        tr.push('<tr>');
                        tr.push('<td>' + value.find("ns2\\:id_document").text() + '</td>');
                        tr.push('<td>' + value.find("ns2\\:type_document").text() + '</td>');
                        tr.push('<td>' + value.find("ns2\\:seria").text() + '</td>');
                        tr.push('<td>' + value.find("ns2\\:numar").text() + '</td>');
                        tr.push('<td>' + value.find("ns2\\:snils").text() + '</td>');
                        tr.push('<td>' + value.find("ns2\\:polis").text() + '</td>');
                        tr.push('</tr>');
                        $("tr").not(":first").hide();
                        $('table').append($(tr.join('')));
                    }  
                } else {                               
                    console.log("Server сode: ", xhr.status );

                }
            }
        };
    });
};


