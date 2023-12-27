function listDocumentSoap(){
    $(document.getElementById("allSoap")).on( "click",function(){
    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8088/ws' );
    var sr = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gen="com/itrail/soap/generated">' +
            '   <soapenv:Header/> ' +
            '     <soapenv:Body> ' +
            '       <gen:getDocumentRequestFindAll/> ' +
            '     </soapenv:Body> ' +
            '   </soapenv:Envelope>';
    xhr.withCredentials = true;
    xhr.setRequestHeader('Content-Type', 'text/xml');
    xhr.send(sr);
    xhr.onreadystatechange = function ( event ) {
            if (xhr.readyState == 4 && xhr.status == 200) {
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
            }else{
                console.log(xhr.status);
            }
        };
    });
};

function listDocumentRest(){
    $(document.getElementById("allRest")).on( "click",function(){
        $.getJSON('http://localhost:8082/web/documents/list', function(json) {
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

function tableClear(){
    console.log('clear');
    $(document.getElementById("allСlear")).on( "click",function(){
       $("tr").not(":first").hide();
    });

};

function findByIdDocument(){
    $(document.getElementById("findById")).on( "click",function(){
        var word = $('#wordFound').val();

        let xhr = new XMLHttpRequest();
        xhr.open('POST', 'http://localhost:8088/ws' );
        sr = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gen="com/itrail/soap/generated">'+
            '   <soapenv:Header/>'+
            '   <soapenv:Body>'+
            '	  <gen:getDocumentRequestFindById>'+
            '		 <gen:id_document>1</gen:id_document>'+
            '	  </gen:getDocumentRequestFindById>'+
            '   </soapenv:Body>'+
            '</soapenv:Envelope>';
        xhr.withCredentials = true;
        xhr.onreadystatechange = function ( event ) {
                if (xhr.readyState == 4 && xhr.status == 200) {
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
                }else{
                    console.log(xhr.status);
                }
            };
        xhr.setRequestHeader('Content-Type', 'text/xml');
        xhr.send(sr);
    });
}