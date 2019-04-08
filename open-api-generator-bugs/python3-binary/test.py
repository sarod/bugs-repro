from python_client import ApiClient, Configuration, DefaultApi


config = Configuration()
config.username = 'admin'
config.password = 'admin'

api = DefaultApi(ApiClient(config))

with open('zip.zip', 'rb') as file:
    api.import_image_library(name='imageLib', body=file.read())
