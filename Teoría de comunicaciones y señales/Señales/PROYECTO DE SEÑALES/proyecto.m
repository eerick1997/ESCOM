function varargout = proyecto(varargin)
% PROYECTO MATLAB code for proyecto.fig
%      PROYECTO, by itself, creates a new PROYECTO or raises the existing
%      singleton*.
%
%      H = PROYECTO returns the handle to a new PROYECTO or the handle to
%      the existing singleton*.
%
%      PROYECTO('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in PROYECTO.M with the given input arguments.
%
%      PROYECTO('Property','Value',...) creates a new PROYECTO or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before proyecto_OpeningFcn gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to proyecto_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% Edit the above text to modify the response to help proyecto

% Last Modified by GUIDE v2.5 19-Jun-2018 14:07:44

% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @proyecto_OpeningFcn, ...
                   'gui_OutputFcn',  @proyecto_OutputFcn, ...
                   'gui_LayoutFcn',  [] , ...
                   'gui_Callback',   []);
if nargin && ischar(varargin{1})
    gui_State.gui_Callback = str2func(varargin{1});
end

if nargout
    [varargout{1:nargout}] = gui_mainfcn(gui_State, varargin{:});
else
    gui_mainfcn(gui_State, varargin{:});
end
% End initialization code - DO NOT EDIT


% --- Executes just before proyecto is made visible.
function proyecto_OpeningFcn(hObject, eventdata, handles, varargin)
% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to proyecto (see VARARGIN)

% Choose default command line output for proyecto
handles.output = hObject;

% Update handles structure
guidata(hObject, handles);

axes(handles.grafica_original)
xlim([0,1])
ylim([0,2]) 
grid 
axes(handles.grafica_copia)
xlim([0,1])
ylim([0,2]) 
grid 

set(handles.desplazar_texto,'String','');



% UIWAIT makes proyecto wait for user response (see UIRESUME)
% uiwait(handles.figure1);


% --- Outputs from this function are returned to the command line.
function varargout = proyecto_OutputFcn(hObject, eventdata, handles) 
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;


% --- Executes on button press in reproduciror_button.
function reproduciror_button_Callback(hObject, eventdata, handles)
% hObject    handle to reproduciror_button (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
global myoriginalRecording;
sound(myoriginalRecording); %Reproducimos los datos normalmente

% --- Executes on button press in reproducircop_button.
function reproducircop_button_Callback(hObject, eventdata, handles)
% hObject    handle to reproducircop_button (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
global myRecording; 
sound(myRecording);

% --- Executes on button press in grabar_sonido.
function grabar_sonido_Callback(hObject, eventdata, handles)
% hObject    handle to grabar_sonido (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
global myRecording;
global myoriginalRecording;
recObj=audiorecorder; %Declaramos el objeto a guardar
disp('Start speaking')
recordblocking(recObj,3);%Sera de 3 segundos
disp('End of Recording.');
myRecording = getaudiodata(recObj); %convertimos el audio en datos
myoriginalRecording = getaudiodata(recObj);
%%FUNCION DE GRAFICAR
axes(handles.grafica_original); 
grid
plot(myRecording);
axes(handles.grafica_copia);
grid 
cla(handles.grafica_copia,'reset')


% --- Executes on button press in desplazar_button.
function desplazar_button_Callback(hObject, eventdata, handles)
% hObject    handle to desplazar_button (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
global myRecording
auxP = size(myRecording);
n0 = str2double(get(handles.desplazar_texto,'String'));
Xq = myRecording(n0:1:auxP);
axes(handles.grafica_copia);
plot(Xq);
sound(Xq);
myRecording = Xq;


% --- Executes on button press in amplificar_button.
function amplificar_button_Callback(hObject, eventdata, handles)
% hObject    handle to amplificar_button (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
global myRecording;
Ampli = str2double(get(handles.amplificar_texto,'String'));
AmpliD = myRecording * Ampli;
axes(handles.grafica_copia);
plot(AmpliD);
sound(AmpliD);
myRecording = AmpliD;

% --- Executes on button press in atenuar_button.
function atenuar_button_Callback(hObject, eventdata, handles)
% hObject    handle to atenuar_button (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
global myRecording;
Atenua = str2double(get(handles.atenuar_texto,'String'));
AtenuaD = myRecording / Atenua;
axes(handles.grafica_copia);
plot(AtenuaD);
sound(AtenuaD);
myRecording = AtenuaD;

% --- Executes on button press in diezmar_button.
function diezmar_button_Callback(hObject, eventdata, handles)
% hObject    handle to diezmar_button (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
global myRecording;
Diezma = str2double(get(handles.diezmar_texto,'String'));
DiezmaD = myRecording(1:Diezma:end);
axes(handles.grafica_copia);
plot(DiezmaD);
sound(DiezmaD);
myRecording = DiezmaD;

% --- Executes on button press in interpolar_button.
function interpolar_button_Callback(hObject, eventdata, handles)
% hObject    handle to interpolar_button (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
global myRecording
auxP = size(myRecording);
x = (0:auxP-1);
Interp = str2double(get(handles.interpolar_texto,'String'));
Xq = (0:1/Interp:auxP);
InterpD = interp1(x,myRecording,Xq,'linear');
axes(handles.grafica_copia);
axes(handles.grafica_copia);
plot(InterpD);
sound(InterpD);
myRecording = InterpD;

% --- Executes on button press in reflejar_button.
function reflejar_button_Callback(hObject, eventdata, handles)
% hObject    handle to reflejar_button (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
global myRecording;
Refleja = myRecording(end:-1:1);
axes(handles.grafica_copia); 
plot(Refleja);
sound(Refleja);
myRecording = Refleja;


function desplazar_texto_Callback(hObject, eventdata, handles)
% hObject    handle to desplazar_texto (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of desplazar_texto as text
%        str2double(get(hObject,'String')) returns contents of desplazar_texto as a double


% --- Executes during object creation, after setting all properties.
function desplazar_texto_CreateFcn(hObject, eventdata, handles)
% hObject    handle to desplazar_texto (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function amplificar_texto_Callback(hObject, eventdata, handles)
% hObject    handle to amplificar_texto (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of amplificar_texto as text
%        str2double(get(hObject,'String')) returns contents of amplificar_texto as a double


% --- Executes during object creation, after setting all properties.
function amplificar_texto_CreateFcn(hObject, eventdata, handles)
% hObject    handle to amplificar_texto (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function atenuar_texto_Callback(hObject, eventdata, handles)
% hObject    handle to atenuar_texto (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of atenuar_texto as text
%        str2double(get(hObject,'String')) returns contents of atenuar_texto as a double


% --- Executes during object creation, after setting all properties.
function atenuar_texto_CreateFcn(hObject, eventdata, handles)
% hObject    handle to atenuar_texto (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function diezmar_texto_Callback(hObject, eventdata, handles)
% hObject    handle to diezmar_texto (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of diezmar_texto as text
%        str2double(get(hObject,'String')) returns contents of diezmar_texto as a double


% --- Executes during object creation, after setting all properties.
function diezmar_texto_CreateFcn(hObject, eventdata, handles)
% hObject    handle to diezmar_texto (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end

function interpolar_texto_Callback(hObject, eventdata, handles)
% hObject    handle to interpolar_texto (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of interpolar_texto as text
%        str2double(get(hObject,'String')) returns contents of interpolar_texto as a double


% --- Executes during object creation, after setting all properties.
function interpolar_texto_CreateFcn(hObject, eventdata, handles)
% hObject    handle to interpolar_texto (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes on button press in restaurar.
function restaurar_Callback(hObject, eventdata, handles)
% hObject    handle to restaurar (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
global myoriginalRecording; 
global myRecording;
axes(handles.grafica_copia);
myRecording = myoriginalRecording;
cla(handles.grafica_copia,'reset')
sound(myoriginalRecording);
